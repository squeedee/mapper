(ns mapper.csg.operators-test
  (:require [expectations :refer :all]
            [mapper.util.diff :refer :all]
            [mapper.core :refer :all]
            [mapper.csg.shapes :refer :all]
            [mapper.csg.operators :refer :all]))

(defrecord NoDiff [dimensions expected-map]
  CustomPred
  (expect-fn [_ actual-map] (= false (diff? dimensions actual-map expected-map)))
  (expected-message [_ _ str-e str-a] (format "expected: %s %s" str-e str-a))
  (actual-message [_ _ _ _] (format "actual: See visual diff"))
  (message [_ actual-map _ _] (format "Visual diff ->\n%s"
                                      (visual-diff (first dimensions)
                                                   (diff dimensions actual-map expected-map)))))

(def rect1 (rect [1 1 10 10]))
(def rect2 (rect [8 8 17 17]))

;; Union ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def comp1 (union (rect [1 1 10 10])
                  (rect [8 8 17 17])))
(def bool-map1
  (create-map 20 (map #(= %1 \#)
                      (str "...................."
                           ".##########........."
                           ".##########........."
                           ".##########........."
                           ".##########........."
                           ".##########........."
                           ".##########........."
                           ".##########........."
                           ".#################.."
                           ".#################.."
                           ".#################.."
                           ".........#########.."
                           ".........#########.."
                           ".........#########.."
                           ".........#########.."
                           ".........#########.."
                           ".........#########.."
                           ".........#########.."
                           "...................."
                           "...................."))))

(expect (->NoDiff [20 20] comp1) comp1)
(expect (->NoDiff [20 20] comp1) bool-map1)
