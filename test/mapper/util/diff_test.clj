(ns mapper.util.diff-test
  (:require [expectations :refer :all]
            [mapper.core :refer :all]
            [mapper.util.diff :refer :all]))

(def map1 (create-map 2 [:a :b :c :d :e :f]))
(def map2 (create-map 2 [:c :b :a :d :e :a]))

(expect '(false true false true true false)
        (diff [2 3] map1 map2))

(expect false
        (diff? [2 3] map1 map2))

(expect true
        (diff? [2 3] map1 map1))