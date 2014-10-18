(ns mapper.diff-test
  (:require [expectations :refer :all]
            [mapper.diff :refer :all]))
;
;(expect '(false true true false)
;        (diff [2 2]
;              `()))