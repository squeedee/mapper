(ns mapper.util.diff
  (:require [mapper.util :refer :all]
            [mapper.core :refer :all]
            [clojure.data :as data]
            [clojure.string :as string]))

(defn left [diff]
  (diff 0))

(defn right [diff]
  (diff 1))

(defn intersection [diff]
  (diff 2))

(defn diff
  ([[width height] map-a map-b]
   "A utility for testing map equality via clojure.data/diff. Converts map functions to sequences for diffing."
   (data/diff (map-as-list [width height] map-a)
         (map-as-list [width height] map-b))))

(defn diff? [dimensions map-a map-b]
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same."
  (let [diff-result (diff dimensions map-a map-b)]
    (not (and (nil? (left diff-result))
         (nil? (right diff-result))))))

(def diff-translation-rules
  {false \.
   true \#
   nil "!"
  })

(defn seq-translate [rules seq]
  (map #(rules %1) seq))

(defn diff-translate [diff-result]
  (seq-translate diff-translation-rules (intersection diff-result)))

(defn lines [width diff-result] (map #(apply str %1) (partition width (diff-translate diff-result))))

(defn visual-diff [width diff-result]
  (string/join \newline (lines width diff-result)))