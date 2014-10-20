(ns mapper.rendering.text
  (:require [clojure.string :as string]
            [mapper.rendering.util :refer :all]))

(def bool-translation-rules
  "Translation rules for visualizing boolean maps"
  {false \.
   true  \#})

(defn visual-map
  "Generate a text map from a sequence. Rules specify how the sequence elements are translated."
  [dimensions seq &
   {:keys [rule-map]
    :or   {rule-map bool-translation-rules}}]
  (string/join \newline
               (map #(apply str %1)
                    (partition (:width dimensions)
                               (seq-translate rule-map seq)))))
