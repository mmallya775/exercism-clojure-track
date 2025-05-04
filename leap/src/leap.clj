(ns leap)

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  ;; function body
  (cond
    (and (= 0 (mod year 4))
         (not (= 0 (mod year 100)))) true

    (and (= 0 (mod year 100))
         (= 0 (mod year 400)))       true

    :else false))
