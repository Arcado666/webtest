package com.webtest.utils;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetUtil
{
  public static Map<String, String> allIP()
  {
    Map allIP = new HashMap();
    try
    {
      Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
      NetworkInterface netInter;
      while (netInterfaces.hasMoreElements())
      {
        netInter = (NetworkInterface)netInterfaces.nextElement();

        List<InterfaceAddress> address = netInter.getInterfaceAddresses();
        for (InterfaceAddress interAddr : address)
        {
          InetAddress addr = interAddr.getAddress();
          if ((addr.isLoopbackAddress()) || (addr.isLinkLocalAddress()) || ((addr instanceof Inet6Address)))
          {
            continue;
          }

          allIP.put(netInter.getDisplayName(), addr.getHostAddress());
        }
      }
    }
    catch (SocketException e)
    {
      e.printStackTrace();
    }

    return allIP;
  }
}
