(ns mapper.csg.shapes-test
  (:require [expectations :refer :all]
            [mapper.csg.shapes :refer :all]))

;; Rectangle ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def rect1 (rect [3 8 7 14]))

; top left
(expect false (rect1 [2 7]))
(expect false (rect1 [3 7]))
(expect false (rect1 [2 8]))
(expect true (rect1 [3 8]))

; bottom right
(expect false (rect1 [8 15]))
(expect false (rect1 [7 15]))
(expect false (rect1 [8 14]))
(expect true (rect1 [7 14]))
