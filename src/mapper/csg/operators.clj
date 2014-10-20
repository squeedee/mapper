(ns mapper.csg.operators)

(defn union-fn [shapes x y]
    (reduce #(or %1 %2)
            (map #(%1 x y) shapes)))

(defn union [& shapes]
  (partial union-fn shapes))
