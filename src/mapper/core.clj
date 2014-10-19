(ns mapper.core
  (:import (clojure.lang Seqable))
  (:refer-clojure :exclude [map get])
  (:require [mapper.util :refer :all]))

(defprotocol FlatMapping
  (row-offset [this y])
  (offset [this x y]))

(defrecord Dimensions [width height]
  FlatMapping
  (row-offset [this y]
    (* y (:width this)))
  (offset [this x y]
    (+ x (row-offset this y))))

(defprotocol Lookupable
  (read-loc [this x y]))

(deftype Map [dimensions map-fn]
  Lookupable
  (read-loc [this x y]
    ((.map-fn this) x y))
  Seqable
  (seq [this]
    (for [y (range (:height dimensions)) x (range (:width dimensions))]
      (read-loc this x y))))

(defn create-map [dimensions coll]
  (->Map dimensions
         (fn [x y]
           (nth coll
                (offset dimensions x y)))))

