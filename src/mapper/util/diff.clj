(ns mapper.util.diff
  (:require [mapper.util :refer :all]
            [mapper.core :refer :all]
            [clojure.data :as data]))

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
    (and (nil? (left diff-result))
         (nil? (right diff-result)))))
