(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond
    (neg? balance) -3.213
    (< balance 1000) 0.5
    (and (>= balance 1000)
         (<  balance 5000)) 1.621
    :else 2.475))


(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (let [interest (* (bigdec (interest-rate balance)) (abs balance) 0.01M)
        updated-balance (+ interest balance)]
    (bigdec updated-balance)))


(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (let [tax-free (if (pos? balance)
                   (* 2 tax-free-percentage balance 0.01)
                   0)]
    (int tax-free)))
