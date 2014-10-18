(ns mapper.util.diff
  (:require [mapper.util :refer :all]
            [mapper.core :refer :all]))

(defn diff
  ([map-a-coll map-b-coll]
   (map = map-a-coll map-b-coll))
  ([[width height] map-a map-b]
   "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same.
  E.g.: diff [2 2] '(:a :b :c :d) '(:a :b :c :z) => '(true true true false)"
   (diff (map-as-list [width height] map-a)
         (map-as-list [width height] map-b))))

(defn diff? [dimensions map-a map-b]
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same.
  E.g.: diff [2 2] '(:a :b :c :d) '(:a :b :c :z) => false
        diff [2 2] '(:a :b :c :d) '(:a :b :c :d) => true"
  (every? true? (diff dimensions map-a map-b)))
