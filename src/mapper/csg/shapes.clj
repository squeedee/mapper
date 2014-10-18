(ns mapper.csg.shapes)

(defn rect-fn [position location]
  (let [[left top right bottom] position
        [x y] location]
    (and (>= x left)
       (<= x right)
       (>= y top)
       (<= y bottom))))

(defn rect [position]
  (partial rect-fn position))
