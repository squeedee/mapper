(ns mapper.rendering.util_test
  (:require [expectations :refer :all]
            [mapper.rendering.util :refer :all]))

(expect `(\c \a \b)
        (seq-translate {true  \a
                        false \b
                        nil   \c}
                       '(nil true false)))