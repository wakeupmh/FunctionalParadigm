(ns hospital.workday
  (:use [clojure.pprint])
  (:require [hospital.model :as h.model]
            [hospital.business :as h.business]))

(defn arrive-at [person]
  (def hospital (h.business/arrive-at :ticket-window person)))

; ERROR: global namespace symbol concurrency issues being root binded and shared between threads
(defn simulate-day []
  (def hospital (h.model/new-hospital))
  (.start (.Thread (fn [] (arrive-at "111"))))
  (.start (.Thread (fn [] (arrive-at "222"))))
  (.start (.Thread (fn [] (arrive-at "333"))))
  (.start (.Thread (fn [] (arrive-at "444"))))
  (.start (.Thread (fn [] (arrive-at "555"))))
  (.start (.Thread (fn [] (arrive-at "666"))))
  (.start (.Thread (fn [] (arrive-at "777"))))
  (.start (.Thread (fn [] (arrive-at "888"))))
  (.start (.Thread (fn [] (Thread/sleep 4000)))))




;; error implementation below

(defn simulate []
  ;root binding
  (def hospital (h.model/new-hospital))
  (h.business/arrive-at hospital :ticket-window "444")
  (h.business/arrive-at hospital :ticket-window "555")
  (h.business/arrive-at hospital :ticket-window "666")
  (h.business/arrive-at hospital :exams "111")
  (h.business/arrive-at hospital :doctors "444")
  (h.business/arrive-at hospital :nurses "333")

  (h.logic/call hospital :exams)
  (h.logic/call hospital :doctors)
  (h.logic/call hospital :ticket-window)
  (pprint hospital))








