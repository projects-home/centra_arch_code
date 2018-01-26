/**
 * COPYRIGHT (C) 2010 LY. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of 3KW.
 *
 * Created By: zzqiang
 * Created On: 2013-10-14
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.ifudata.ums.service.sgip;

import java.util.List;

import com.ifudata.ums.service.sgip.body.SGIPCommand;
import com.ifudata.ums.service.sgip.body.command.Submit;
import com.ifudata.ums.service.sgip.constant.SGIPConstant;
import com.ifudata.ums.service.sgip.factory.SGIPFactory;
import com.ifudata.ums.service.sgip.head.SGIPMsgHead;
import com.ifudata.ums.service.sgip.interf.SGIPByteData;
import com.ifudata.ums.service.sgip.util.SGIPUtils;

public class SGIPMsg implements SGIPByteData {

	private SGIPMsgHead head;
	
	private SGIPCommand command;
	
	public SGIPMsgHead getHead()
	{
		return head;
	}

	public void setHead(SGIPMsgHead head)
	{
		this.head = head;
	}

	public SGIPCommand getCommand()
	{
		return command;
	}

	public void setCommand(SGIPCommand command)
	{
		this.command = command;
	}

	private void calcute()
	{
		long messageLength = this.command.getCommandLength() + SGIPMsgHead.HEAD_LENGTH;
		this.head.setMessageLength(messageLength);
	}

	@Override
	public byte[] getByteData()
	{
		byte[] commandBytes = command.getByteData();
		calcute();
		return SGIPUtils.mergeBytes(head.getByteData(), commandBytes);
	}

	public byte[] getByteDataNoRand()
	{
		byte[] commandBytes = command.getByteData();
		calcute();
		return SGIPUtils.mergeBytes(head.getByteDataNoRand(), commandBytes);
	}
	
	public void setUserNumbers(List<String> listUserNumber,String messageContent)
	{
		if(head == null || command == null || head.getCommandId() !=  SGIPConstant.SGIP_SUBMIT)
		{
			return;
		}
		Submit sub = (Submit)command;
		sub.setListUserNumber(listUserNumber);
		sub.setMessageContent(messageContent);
	}

	private void initHead(byte[] source)
	{
		head = new SGIPMsgHead();
		byte[] headByte = new byte[SGIPMsgHead.HEAD_LENGTH];
		SGIPUtils.copyBytes(source, headByte, 1, SGIPMsgHead.HEAD_LENGTH, 1);
		head.initPropertiesByBytes(headByte);
	}
	
	private void initCommand(byte[] source) throws Exception
	{
		if(head == null || head.getCommandId() == null)
		{
			return;
		}
		long commandId = head.getCommandId();
		command = SGIPFactory.getCommandByCommandId(commandId);

		byte[] commandByte = new byte[source.length - SGIPMsgHead.HEAD_LENGTH];
		SGIPUtils.copyBytes(source, commandByte, SGIPMsgHead.HEAD_LENGTH+1, commandByte.length, 1);
		command.initPropertiesByBytes(commandByte);
	}
	
	@Override
	public void initPropertiesByBytes(byte[] source) throws Exception
	{
		initHead(source);
		try
		{
			initCommand(source);
		} catch (Exception e)
		{
			System.out.println("initCommand error:" + source);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public String toString()
	{
		return "SGIPMsg [head=" + head + ", command=" + command + "]";
	}
}
