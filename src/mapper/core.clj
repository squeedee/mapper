(ns mapper.core
  (:refer-clojure :exclude [map get])
  (:import (clojure.lang Seqable)))

(defprotocol FlatMapping
  (row-offset [this y])
  (offset [this x y]))

(defrecord Dimensions [width height]
  FlatMapping
  (row-offset [this y]
    (* y width))
  (offset [this x y]
    (+ x (row-offset this y))))

(defn create-map-fn [dimensions coll]
  (fn [x y]
    (nth coll
         (offset dimensions x y))))

(defn map-fn-seq [dimensions map-fn]
  (for [y (range (:height dimensions))
        x (range (:width dimensions))]
    (map-fn x y)))