(defn value-discounted 
    "Function to apply 15% discount in a value"
    [value]
    (* value (- 1 0.15)))

(value-discounted 1000)