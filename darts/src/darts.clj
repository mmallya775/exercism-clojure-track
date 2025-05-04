(ns darts
  (:require [clojure.math :as m]))

(defn score
  "Calculates the score of a dart throw"
  [x y]
  ;; function body
  (let [hypot (->> (+ (m/pow x 2) (m/pow y 2))
                   m/sqrt)
        score  (cond
                 (> hypot 10) 0
                 (> hypot 5) 1
                 (> hypot 1) 5
                 (>= hypot 0) 10)]
    score))


