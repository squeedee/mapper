(ns mapper.util.diff
  (:require [mapper.core :refer :all]
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
   ;(data/diff (map-seq [width height] map-a)
   ;      (map-seq [width height] map-b))))
   ))
(defn diff? [dimensions map-a map-b]
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same."
  (let [diff-result (diff dimensions map-a map-b)]
    (not (and (nil? (left diff-result))
         (nil? (right diff-result))))))
