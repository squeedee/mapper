(ns mapper.rendering.text
  (:require [clojure.string :as string]
            [mapper.rendering.util :refer :all]))

(def bool-translation-rules
  "Translation rules for visualizing boolean maps"
  {false \.
   true \#})

(defn visual-map [rules width seq]
  "Generate a text map from a sequence. Rules specify how the sequence elements are translated."
  (string/join \newline
               (map #(apply str %1)
                    (partition width
                               (seq-translate rules seq)))))
