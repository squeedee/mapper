(ns mapper.rendering.util)

(defn seq-translate [rules seq]
  "applies translation rules to a map sequence"
  (map #(rules %1) seq))
