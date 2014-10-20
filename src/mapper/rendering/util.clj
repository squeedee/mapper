(ns mapper.rendering.util)

(defn seq-translate
  "applies translation rules to a map sequence"
  [rules seq]
  (map #(rules %1) seq))
