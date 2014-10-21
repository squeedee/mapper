(ns mapper.csg.operators)

(defn union-fn [shapes x y]
  (reduce #(or %1 %2)
          (map #(%1 x y) shapes)))

(defn union [& shapes]
  (partial union-fn shapes))

(defn- xor [a b]
  (and (or a b) (not (and a b))))

(defn subtraction-fn
  [shapes x y]

  (reduce #(xor %1 %2)
          (map #(%1 x y) shapes)))

(defn subtraction [& shapes]
  (partial subtraction-fn shapes))