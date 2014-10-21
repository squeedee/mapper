(ns mapper.csg.shapes-test
  (:require [expectations :refer :all]
            [mapper.csg.shapes :refer :all]))

;; Rectangle ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def rect-fn (rect [3 8 7 14]))

; top left
(expect false (rect-fn 2 7))
(expect false (rect-fn 3 7))
(expect false (rect-fn 2 8))
(expect true (rect-fn 3 8))

; bottom right
(expect false (rect-fn 8 15))
(expect false (rect-fn 7 15))
(expect false (rect-fn 8 14))
(expect true (rect-fn 7 14))
