(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [lin (* 221 speed)]
    (cond
      (=  speed  0)  (* 0    lin)
      (<= speed  4)  (* 1    lin)
      (<= speed  8)  (* 0.9  lin)
      (=  speed  9)  (* 0.8  lin)
      (=  speed 10)  (* 0.77 lin))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
