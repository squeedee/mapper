(ns mapper.csg.operators-test
  (:require [expectations :refer :all]
            [mapper.csg.shapes :refer :all]
            [mapper.csg.operators :refer :all]))

(def rect1 (rect [1 1 10 10]))
(def rect2 (rect [8 8 17 17]))

;; Union ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def comp1 (union (rect [1 1 10 10])
                  (rect [8 8 17 17])))
;
;(expect false (map-differs?
;                (str "...................."
;                     ".##########........."
;                     ".##########........."
;                     ".##########........."
;                     ".##########........."
;                     ".##########........."
;                     ".##########........."
;                     ".##########........."
;                     ".#################.."
;                     ".#################.."
;                     ".#################.."
;                     ".........#########.."
;                     ".........#########.."
;                     ".........#########.."
;                     ".........#########.."
;                     ".........#########.."
;                     ".........#########.."
;                     ".........#########.."
;                     "...................."
;                     "....................")
;                20
;                comp1))
;
;; top left
;(expect false (comp1 [0 0]))
;(expect false (comp1 [0 1]))
;(expect false (comp1 [1 0]))
;(expect true (comp1 [1 1]))
;
;; bottom right
;(expect false (comp1 [18 18]))
;(expect false (comp1 [17 18]))
;(expect false (comp1 [18 17]))
;(expect true (comp1 [17 17]))
;
;; bottom left nook
;(expect false (comp1 [7 11]))
;(expect true (comp1 [8 11]))
;(expect true (comp1 [8 10]))
;(expect true (comp1 [7 10]))
;
;; top right nook
;(expect false (comp1 [11 7]))
;(expect true (comp1 [10 7]))
;(expect true (comp1 [11 8]))
;(expect true (comp1 [10 8]))
