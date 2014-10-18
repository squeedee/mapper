(ns mapper.util-test
  (:require [expectations :refer :all]
            [mapper.util :refer :all]))

(expect [0 0] (coordinates 10 0))
(expect [3 0] (coordinates 10 3))
(expect [0 1] (coordinates 10 10))
(expect [5 3] (coordinates 10 35))

(expect '(1 2 3 nil)
        (pad `(1 2 3) `(:a :b :c :d)))

(expect '(:a :b :c :d)
        (pad `(:a :b :c :d) `(1 2 3)))