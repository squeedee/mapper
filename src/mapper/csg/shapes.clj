(ns mapper.csg.shapes)

(defn- rect-fn
  "A boolean map function that returns true inside the rectangle described
   by position"
  [aabb x y]
  (let [[left top right bottom] aabb]
    (and (>= x left)
       (<= x right)
       (>= y top)
       (<= y bottom))))

(defn rect
  "Returns a boolean map function that returns true inside the rectangle described
   by position"
  [aabb]
  (partial rect-fn aabb))