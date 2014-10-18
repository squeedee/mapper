(ns mapper.csg.operators-test
  (:require [expectations :refer :all]
            [mapper.util.diff :refer :all]
            [mapper.core :refer :all]
            [clojure.string :as string]
            [mapper.rendering.text :refer :all]
            [mapper.csg.shapes :refer :all]
            [mapper.csg.operators :refer :all]))

(defn create-map-from-string [width map-string]
  (create-map width (map #(= %1 \#) map-string)))

(defrecord NoDiff [dimensions expected-map]
  CustomPred
  (expect-fn [_ actual-map-fn]
    (= false
       (diff? dimensions
              actual-map-fn
              (create-map-from-string (first dimensions) expected-map))))
  (expected-message [_ _ str-e str-a]
    (format "expected ->\n%s"
            (string/join \newline
                         (map #(apply str %1) (partition (first dimensions) expected-map)))))
  (actual-message [_ actual-map-fn _ _]
    (format "actual ->\n%s"
            (visual-map bool-translation-rules (first dimensions) (map-seq dimensions actual-map-fn))))

  (message [_ actual-map _ _] (format "Visual diff ->")))
                                      ;(message [_ actual-map _ _] (format "Visual diff ->\n%s"
                                      ;(visual-diff (first dimensions)
                                      ;             (diff dimensions actual-map expected-map)))))

(def rect1 (rect [1 1 10 10]))
(def rect2 (rect [8 8 17 17]))

;; Union ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def comp1 (union (rect [1 1 10 10])
                  (rect [8 8 17 17])))

(def map1
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
       "...................."))

(expect (->NoDiff [20 20] map1) comp1)
