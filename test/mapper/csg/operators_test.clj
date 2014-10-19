;(ns mapper.csg.operators-test
;  (:require [expectations :refer :all]
;            [mapper.util.diff :refer :all]
;            [mapper.core :refer :all]
;            [clojure.string :as string]
;            [mapper.rendering.text :refer :all]
;            [mapper.csg.shapes :refer :all]
;            [mapper.csg.operators :refer :all]))
;
;(defn- create-map-from-string [width map-string]
;  (create-map width (map #(= %1 \#) map-string)))
;
;(def diff-translation-rules
;  {false \.
;   true  \#
;   nil   "!"
;  })
;
;(defrecord NoDiff [width height expected-map]
;  CustomPred
;
;  (expect-fn [_ actual-map-fn]
;    (= false
;       (diff? [width height]
;              actual-map-fn
;              (create-map-from-string width expected-map))))
;
;  (expected-message [_ _ str-e str-a]
;    (format "expected ->\n%s"
;            (string/join \newline
;                         (map #(apply str %1) (partition width expected-map)))))
;
;  (actual-message [_ actual-map-fn _ _]
;    (format "actual ->\n%s"
;            (visual-map bool-translation-rules width (map-seq [width height] actual-map-fn))))
;
;  (message [_ actual-map-fn _ _] (format "Visual diff ->\n%s"
;                                         (visual-map diff-translation-rules
;                                                     width
;                                                     (intersection (diff [width height]
;                                                                         actual-map-fn
;                                                                         (create-map-from-string width expected-map)))))))
;
;(def rect1 (rect [1 1 10 10]))
;(def rect2 (rect [8 8 17 17]))
;
;;; Union ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
;(def comp1 (union rect1 rect2))
;
;(def map1
;  (str "...................."
;       ".##########........."
;       ".##########........."
;       ".##########........."
;       ".##########........."
;       ".##########........."
;       ".##########........."
;       ".##########........."
;       ".#################.."
;       ".#################.."
;       ".#################.."
;       "........##########.."
;       "........##########.."
;       "........##########.."
;       "........##########.."
;       "........##########.."
;       "........##########.."
;       "........##########.."
;       "...................."
;       "...................."))
;
;(expect (->NoDiff 20 20 map1) comp1)
