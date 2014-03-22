package org.spacehq.mcprotocol.standard.packet;

import org.spacehq.mcprotocol.event.PacketVisitor;
import org.spacehq.mcprotocol.net.io.NetInput;
import org.spacehq.mcprotocol.net.io.NetOutput;
import java.io.IOException;

import org.spacehq.mcprotocol.net.Client;
import org.spacehq.mcprotocol.net.ServerConnection;
import org.spacehq.mcprotocol.packet.Packet;

public class PacketAnimation extends Packet {

	public int entityId;
	public byte animation;

	public PacketAnimation() {
	}

	public PacketAnimation(int entityId, byte animation) {
		this.entityId = entityId;
		this.animation = animation;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.entityId = in.readInt();
		this.animation = in.readByte();
	}

	@Override
	public void write(NetOutput out) throws IOException {
		out.writeInt(this.entityId);
		out.writeByte(this.animation);
	}

	@Override
	public void handleClient(Client conn) {
	}

	@Override
	public void handleServer(ServerConnection conn) {
	}

	@Override
	public int getId() {
		return 18;
	}

	@Override
	public void accept(PacketVisitor visitor) {
		visitor.visit(this);
	}

}