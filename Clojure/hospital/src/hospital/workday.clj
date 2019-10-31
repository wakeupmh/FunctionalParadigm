(ns hospital.workday
  (:use [clojure.pprint])
  (:require [hospital.model :as h.model]
            [hospital.business :as h.business]))


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



