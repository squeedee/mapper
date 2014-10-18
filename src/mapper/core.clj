(ns mapper.core
  (:refer-clojure :exclude [map])
  (:require [mapper.util :refer :all]))

(defn create-map [width coll]
  (fn [[x y]]
    (nth coll (+ x (* y width)))))