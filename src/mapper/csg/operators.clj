(ns mapper.csg.operators)

(defn union-fn [shapes location]
    (reduce #(or %1 %2)
            (map #(%1 location) shapes)))

(defn union [& shapes]
  (partial union-fn shapes))
