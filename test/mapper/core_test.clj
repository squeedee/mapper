(ns mapper.core-test
  (:refer-clojure :exclude [map])
  (:require [expectations :refer :all]
            [mapper.core :refer :all]))

(let [map-dimensions (->Dimensions 2 3)
      map-fn (create-map-fn map-dimensions [:a :b :c :d :e :f])]

  (expect :a (map-fn 0 0))
  (expect :b (map-fn 1 0))
  (expect :c (map-fn 0 1))
  (expect :d (map-fn 1 1))
  (expect :e (map-fn 0 2))
  (expect :f (map-fn 1 2))

  (expect '(:a :b :c :d :e :f) (map-fn-seq map-dimensions map-fn)))
