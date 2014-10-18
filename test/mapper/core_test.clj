(ns mapper.core-test
  (:refer-clojure :exclude [map])
  (:require [expectations :refer :all]
            [mapper.core :refer :all]))

(def map (create-map 2 [:a :b :c :d :e :f]))

(expect :a (map [0 0]))
(expect :b (map [1 0]))
(expect :c (map [0 1]))
(expect :d (map [1 1]))
(expect :e (map [0 2]))
(expect :f (map [1 2]))

(expect '(:a :b :c :d :e :f) (map-seq [2 3] map))