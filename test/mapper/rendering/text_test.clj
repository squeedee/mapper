(ns mapper.rendering.text_test
  (:require [expectations :refer :all]
            [mapper.core :refer :all]
            [mapper.rendering.text :refer :all]))

(expect "...\n#.#\n.#.\n###"
        (visual-map (->Dimensions 3 4)
                    '(false false false
                      true false true
                      false true false
                      true true true)))


(expect "1111\n1231\n2312"
        (visual-map (->Dimensions 4 3)
                    '(:a :a :a :a
                      :a :b nil :a
                      :b nil :a :b)
                    :rule-map {:a  1
                               :b  2
                               nil 3}))
