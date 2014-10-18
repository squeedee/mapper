(ns mapper.util.diff
  (:require [mapper.util :refer :all]
            [mapper.core :refer :all]))

(defn diff [[width height] map-a map-b]
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same.
  E.g.: diff [2 2] '(:a :b :c :d) '(:a :b :c :z) => '(true true true false)"
  (let [map-a-coll (map-as-list [width height] map-a)
        map-b-coll (map-as-list [width height] map-b)]
    (map = map-a-coll map-b-coll)))

(defn diff? [dimensions map-a map-b]
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same.
  E.g.: diff [2 2] '(:a :b :c :d) '(:a :b :c :z) => false
        diff [2 2] '(:a :b :c :d) '(:a :b :c :d) => true"
  (every? true? (diff dimensions map-a map-b)))
