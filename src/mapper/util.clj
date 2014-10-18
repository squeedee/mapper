(ns mapper.util)

(defn coordinates [width index]
  [(rem index width) (quot index width)])

(defn pad [coll-a coll-b]
  "pad coll-a with nils to match coll-b's cardinality"
  (concat coll-a (repeat (- (count coll-b) (count coll-a)) nil)))