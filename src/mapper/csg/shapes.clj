(ns mapper.csg.shapes)

(defn- rect-fn [position location]
  "A boolean map function that returns true inside the rectangle described
   by position"
  (let [[left top right bottom] position
        [x y] location]
    (and (>= x left)
       (<= x right)
       (>= y top)
       (<= y bottom))))

(defn rect [position]
  "Returns a boolean map function that returns true inside the rectangle described
   by position"
  (partial rect-fn position))
