(ns resistor-color-duo
  (:require [clojure.string :as str]))

(def colors-range
  ;; definition value
  ["black" "brown" "red" "orange" "yellow"
   "green" "blue" "violet" "grey" "white"])

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [colors]
  (let [mapping          (zipmap colors-range (range))
        resistance-value (+ (* (get mapping (first colors)) 10)
                            (* (get mapping (second colors)) 1))]
    resistance-value))