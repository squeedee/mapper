(ns mapper.util.diff-test
  (:require [expectations :refer :all]
            [mapper.core :refer :all]
            [mapper.util.diff :refer :all]))

(def map-dimensions (->Dimensions 2 3))

(def map1 (create-map-fn map-dimensions [:a :b :c :d :e :f]))
(def map2 (create-map-fn map-dimensions [:c :b :a :d :e :a]))

(expect [[:a nil :c nil nil :f] [:c nil :a nil nil :a] [nil :b nil :d :e]]
        (diff map-dimensions map1 map2))

(expect [:a nil :c nil nil :f]
        (left (diff map-dimensions map1 map2)))

(expect [:c nil :a nil nil :a]
        (right (diff map-dimensions map1 map2)))

(expect [nil :b nil :d :e]
        (intersection (diff map-dimensions map1 map2)))

(expect true
        (diff? map-dimensions map1 map2))

(expect false
        (diff? map-dimensions map1 map1))