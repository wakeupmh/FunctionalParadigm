(ns hospital.collections
  :use [clojure pprint])

(defn test-value
  (let [wait [111 222]]
    (println wait)
    (println (conj wait 333))
    (println (conj wait 444))
    (println (pop wait))                                    ;lifo
    ))
(test-value)

(defn test-list
  (let [wait '(111 222)]
    (println wait)
    (println (conj wait 333))                               ;insert in begin
    (println (conj wait 444))
    (println (pop wait))                                    ;fifo
    ))
(test-list)

(defn test-math-set
  (let [wait #{111 222}]
    (println wait)
    (println (conj wait 333))
    (println (conj wait 444))
    ;(println (pop wait))  ;doesn't work because is a math set
    ))
(test-math-set)

(defn test-queue
  (let [wait (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
    (println wait)
    (println (seq wait))
    (println (seq (conj wait "333")))
    (println (seq (pop wait)))                              ;remove the first element
    (println (peek wait))                                   ;the first element
    (pprint wait)))                                         ;prettie print <-("" "")-< indicates a queue
(test-queue)
