(ns mapper.util.diff-test
  (:require [expectations :refer :all]
            [mapper.core :refer :all]
            [mapper.util.diff :refer :all]))

(def map1 (create-map 2 [:a :b :c :d :e :f]))
(def map2 (create-map 2 [:c :b :a :d :e :a]))

(expect [[:a nil :c nil nil :f] [:c nil :a nil nil :a] [nil :b nil :d :e]]
        (diff [2 3] map1 map2))

(expect [:a nil :c nil nil :f]
        (left (diff [2 3] map1 map2)))

(expect [:c nil :a nil nil :a]
        (right (diff [2 3] map1 map2)))

(expect [nil :b nil :d :e]
        (intersection (diff [2 3] map1 map2)))


(expect false
        (diff? [2 3] map1 map2))

(expect true
        (diff? [2 3] map1 map1))