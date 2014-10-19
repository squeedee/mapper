(ns mapper.core-test
  (:refer-clojure :exclude [map])
  (:require [expectations :refer :all]
            [mapper.core :refer :all]))

(def map (create-map (->Dimensions 2 3) [:a :b :c :d :e :f]))

(expect :a (read-loc map 0 0))
(expect :b (read-loc map 1 0))
(expect :c (read-loc map 0 1))
(expect :d (read-loc map 1 1))
(expect :e (read-loc map 0 2))
(expect :f (read-loc map 1 2))

(expect '(:a :b :c :d :e :f) (seq map))