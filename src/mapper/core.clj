(ns mapper.core
  (:refer-clojure :exclude [map])
  (:require [mapper.util :refer :all]))

(defn create-map [width coll]
  "Creates a map-fn that takes a position paramater to find an entry in the coll"
  (fn [[x y]]
    (nth coll (+ x (* y width)))))

(defn map-seq [[width height] map]
  "produces a flat seq from a map-fn"
  (for [y (range height) x (range width)]
    (map [x y])))

;(defrecord AABB
;  [left top right bottom])