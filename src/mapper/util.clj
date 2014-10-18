(ns mapper.util)

(defn coordinates [width index]
  [(rem index width) (quot index width)])
