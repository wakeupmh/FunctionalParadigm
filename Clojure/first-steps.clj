(defn value-discounted 
    "Function to apply 15% discount in a value"
    [value]
    (let [discount 0.15]
        (* value (- 1 discount))))

(value-discounted 1000)


(defn exp [x n]
  (reduce * (repeat n x)))

(exp 2 3)