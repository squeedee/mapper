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
  "A utility for testing map equality via clojure.data/diff. Converts map functions to sequences for diffing."
  [dimensions map-a-fn map-b-fn]
  (data/diff (map-fn-seq dimensions map-a-fn)
             (map-fn-seq dimensions map-b-fn)))

(defn diff?
  "A utility for testing map equality. Compares map-a and map-b elementwise and returns true if they're the same."
  [dimensions map-a-fn map-b-fn]
  (let [diff-result (diff dimensions map-a-fn map-b-fn)]
    (not (and (nil? (left diff-result))
              (nil? (right diff-result))))))
