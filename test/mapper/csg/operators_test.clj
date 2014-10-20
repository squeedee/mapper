(ns mapper.csg.operators-test
  (:require [expectations :refer :all]
            [mapper.util.diff :refer :all]
            [mapper.core :refer :all]
            [clojure.string :as string]
            [mapper.rendering.text :refer :all]
            [mapper.csg.shapes :refer :all]
            [mapper.csg.operators :refer :all]))

;; Helpers ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- create-map-from-string
  "Helper to generate a boolean map from a string"
  [dimensions map-string]
  (create-map-fn dimensions (map #(= %1 \#) map-string)))

(def diff-translation-rules
  {false \.
   true  \#
   nil   "!"})

(defrecord NoDiff [dimensions expected-map]
  CustomPred

  (expect-fn [_ actual-map-fn]
    (= false
       (diff? dimensions
              actual-map-fn
              (create-map-from-string dimensions expected-map))))

  (expected-message [_ _ _ _]
    (format "expected ->\n%s"
            (string/join \newline
                         (map #(apply str %1) (partition (:width dimensions) expected-map)))))

  (actual-message [_ actual-map-fn _ _]
    (format "actual ->\n%s"
            (visual-map dimensions
                        (map-fn-seq dimensions actual-map-fn))))

  (message [_ actual-map-fn _ _]
    (format "Visual diff ->\n%s"
            (visual-map dimensions
                        (intersection (diff dimensions
                                            actual-map-fn
                                            (create-map-from-string dimensions expected-map)))
                        :rule-map diff-translation-rules))))

;; Test shapes ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def rect1 (rect [1 1 10 10]))
(def rect2 (rect [8 8 17 17]))

;; Union ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def comp1 (union rect1 rect2))

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
       "........##########.."
       "........##########.."
       "........##########.."
       "........##########.."
       "........##########.."
       "........##########.."
       "........##########.."
       "...................."
       "...................."))

(def map-dimensions (->Dimensions 20 20))

(expect (->NoDiff map-dimensions map1) comp1)
