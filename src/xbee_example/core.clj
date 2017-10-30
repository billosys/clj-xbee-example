(ns xbee-example.core
  (:require [clojusc.twig :as logger]
            [xbee.device.core :as xbee]
            [xbee.device.raw802 :as raw802]
            [xbee.models.core :as models])
  (:import (com.digi.xbee.api.exceptions XBeeException))
  (:gen-class))

(defn -main
  ([]
    (-main "COM1"))
  ([port]
    (-main port "9600"))
  ([port baud-rate]
    (-main port baud-rate "This is a test message."))
  ([port baud-rate msg]
    (logger/set-level! '[xbee xbee-example com.digi] :info)
    (let [device (raw802/create-device port baud-rate)]
      (raw802/open device)
      (raw802/send-broadcast-data device msg)
      (raw802/close device))))
