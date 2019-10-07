(ns labs.prediction-bindings-when)

(defn discounted-value
  [value]
  (if (> value 100)
    (let [discount-tax (/ 15 100)
          discount (* value discount-tax)]
      (- value discount))
    value))

