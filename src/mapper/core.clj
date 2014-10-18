(ns mapper.core
  (:refer-clojure :exclude [map])
  (:require [mapper.util :refer :all]))

(defn create-map [width coll]
  "Creates a map-function that takes a position paramater to find an entry in the coll"
  (fn [[x y]]
    (nth coll (+ x (* y width)))))

(defn map-as-list [[width height] map]
  "produces a flat list of a map-functions first width * height entries"
  (for [y (range height) x (range width)]
    (map [x y])))